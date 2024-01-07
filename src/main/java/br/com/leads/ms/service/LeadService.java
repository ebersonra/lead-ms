package br.com.leads.ms.service;

import br.com.leads.ms.domain.dto.LeadDto;
import br.com.leads.ms.domain.exception.LeadException;
import br.com.leads.ms.domain.request.LeadRequest;
import br.com.leads.ms.domain.response.LeadListResponse;
import br.com.leads.ms.domain.response.LeadResponse;
import br.com.leads.ms.entity.Lead;
import br.com.leads.ms.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public LeadListResponse findAll() {

        List<Lead> leads = leadRepository.findAll();

        List<LeadDto> leadDtoList = leads
                .stream()
                .map(this::toDto)
                .toList();

        return new LeadListResponse(leadDtoList);
    }

    public LeadResponse findByPhoneNumber(String phoneNumber) {
        return new LeadResponse(toDto(findLeadByPhone(phoneNumber)));
    }

    public LeadResponse createLead(LeadRequest leadRequest) {

        Lead lead = leadRepository.save(toEntity(leadRequest, Boolean.FALSE));

        return new LeadResponse(toDto(lead));
    }

    public void deleteLead(String phone) {
        leadRepository.delete(findLeadByPhone(phone));
    }

    public LeadResponse updateLead(LeadRequest leadRequest) {

        Lead savedLead = leadRepository.saveAndFlush(toEntity(leadRequest, Boolean.TRUE));
        return new LeadResponse(toDto(savedLead));
    }

    private Lead findLeadByPhone(String phone) {
        return leadRepository
                .findByPhone(formatPhone(phone))
                .orElseThrow(() -> new LeadException(String.format("Lead with phone [%s] not found", phone)));
    }

    private Lead toEntity(LeadRequest leadRequest, boolean isUpdate) {

        if (isUpdate) {
            Lead lead = findLeadByPhone(leadRequest.phone());
            return new Lead(lead.getUniqueId(), formatPhone(leadRequest.phone()), leadRequest.email(), leadRequest.firstname(), leadRequest.lastname());
        }

        verifyIfLeadExists(leadRequest.phone());
        return new Lead(formatPhone(leadRequest.phone()), leadRequest.email(), leadRequest.firstname(), leadRequest.lastname());
    }

    private void verifyIfLeadExists(String phone) {
        leadRepository.findByPhone(formatPhone(phone)).ifPresent(lead -> {
            throw new LeadException(String.format("Lead with phone [%s] already exists", phone));
        });
    }

    private String formatPhone(String phone) {
        return phone.replace(" ", "")
                .replace("-", "")
                .replace("(", "")
                .replace(")", "");
    }

    private LeadDto toDto(Lead lead) {
        return new LeadDto(lead.getUniqueId(), lead.getFirstname(), lead.getEmail(), lead.getPhone(), lead.getLastname());
    }
}
