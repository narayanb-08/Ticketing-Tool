
package com.sumpositive.ticketing.ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sumpositive.ticketing.common.exception.ResourceNotFoundException;
import com.sumpositive.ticketing.ticket.entity.Ticket;
import com.sumpositive.ticketing.ticket.mapper.TicketMapper;
import com.sumpositive.ticketing.ticket.repository.TicketRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository,TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }


    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

   
    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

  
    public List<Ticket> getTicketsByStatus(String status) {
        return ticketRepository.findByStatus(status);
    }



public Ticket updateTicket(Ticket ticket) {

    Long id = ticket.getId();

    Ticket existingTicket = ticketRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Ticket not found with id: " + id));

    ticket.setId(existingTicket.getId());

    return ticketRepository.save(ticket);
}


  
    public void deleteTicket(Long id) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ticket not found with id: " + id));

        ticketRepository.delete(ticket);
    }

  
    public long getTotalTickets() {
        return ticketRepository.count();
    }
}
