package com.rkelectricals.invoicegenerator.service.Impls;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rkelectricals.invoicegenerator.mapper.EntityMapper;
import com.rkelectricals.invoicegenerator.model.ContactDetails;
import com.rkelectricals.invoicegenerator.model.Invoice;
import com.rkelectricals.invoicegenerator.model.Product;
import com.rkelectricals.invoicegenerator.model.DTOs.InvoiceDTO;
import com.rkelectricals.invoicegenerator.repository.ContactDetailsRepository;
import com.rkelectricals.invoicegenerator.repository.InvoiceRepository;
import com.rkelectricals.invoicegenerator.repository.ProductRepository;
import com.rkelectricals.invoicegenerator.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private ContactDetailsRepository contactDetailsRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Invoice saveInvoice(InvoiceDTO invoiceDTO) {
		Invoice invoice = EntityMapper.mapToEntity(invoiceDTO);

		double sum = invoice.getTotalAmount() + invoice.getCgst() + invoice.getSgst();
		double roundedSum = Math.round(sum) - sum;
		invoice.setRoundOff(roundedSum);
		invoice.setInvoiceNumber(getInvoiceNumber());

		ContactDetails seller = contactDetailsRepository.findById(invoiceDTO.getSellerDetailsId()).get();
		if (seller != null) {
			invoice.setSellerDetails(seller);
		}

		ContactDetails buyer = contactDetailsRepository.findById(invoiceDTO.getBuyerDetailsId()).get();
		if (buyer != null) {
			invoice.setBuyerDetails(buyer);
		}

		List<Product> products = productRepository.findAllById(invoiceDTO.getProductIds());
		if (products != null && !products.isEmpty()) {
			invoice.setProducts(products);
		}

		return invoiceRepository.save(invoice);
	}

	@Override
	public Page<Invoice> getAllInvoices(Pageable pageable) {
		return invoiceRepository.findAllByOrderByInvoiceDateDesc(pageable);
	}

	@Override
	public Invoice getInvoiceById(Long id) {
		return invoiceRepository.findById(id).orElse(null);
	}

	public String getInvoiceNumber() {
		String companyPrefix = "RK";
		String financialYearPrefix = getCurrentFinancialYearPrefix();
		long invoiceCount = invoiceRepository.count() + 1;
		return String.format("%s/%s/%02d", companyPrefix, financialYearPrefix, invoiceCount);
	}

	// Utility method to get the current financial year prefix
	private String getCurrentFinancialYearPrefix() {
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int nextYear = currentYear + 1;
		String financialYearPrefix = String.valueOf(currentYear).substring(2) + "-" + String.valueOf(nextYear).substring(2);
		return financialYearPrefix;
	}

	@Override
	public void deleteInvoice(Long id) {
		invoiceRepository.deleteById(id);
	}

}
