
package com.sumpositive.ticketing.ticket.mapper;

import org.springframework.stereotype.Component;

import com.sumpositive.ticketing.ticket.dto.TicketRequestDto;
import com.sumpositive.ticketing.ticket.dto.TicketResponseDto;
import com.sumpositive.ticketing.ticket.entity.Ticket;

@Component
public class TicketMapper {
	
    public TicketResponseDto toResponseDto(Ticket ticket) {

        TicketResponseDto dto = new TicketResponseDto();

        dto.setId(ticket.getId());
        dto.setTitle(ticket.getTitle());
        dto.setDescription(ticket.getDescription());
        dto.setStatus(ticket.getStatus());
        dto.setPriority(ticket.getPriority());

        if (ticket.getAssignee() != null) {
            dto.setAssigneeId(ticket.getAssignee().getId());
        }

        if (ticket.getCreatedBy() != null) {
            dto.setCreatedById(ticket.getCreatedBy().getId());
        }

        dto.setCreatedAt(ticket.getCreatedAt());
        dto.setUpdatedAt(ticket.getUpdatedAt());

        return dto;
    }

    // Convert TicketRequestDto to Ticket entity
    public Ticket toEntity(TicketRequestDto dto) {

        Ticket ticket = new Ticket();

        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setStatus(dto.getStatus());
        ticket.setPriority(dto.getPriority());

        return ticket;
    }
}
