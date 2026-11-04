
package com.sumpositive.ticketing.dashboard.service;

import org.springframework.stereotype.Service;

import com.sumpositive.ticketing.dashboard.dto.DashboardResponse;
import com.sumpositive.ticketing.ticket.repository.TicketRepository;
import com.sumpositive.ticketing.user.repository.UserRepository;

@Service
public class DashboardService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public DashboardService(TicketRepository ticketRepository,
                           UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public DashboardResponse getDashboardStats() {

        long totalTickets = ticketRepository.count();
        long openTickets = ticketRepository.countByStatus("OPEN");
        long inProgressTickets = ticketRepository.countByStatus("IN_PROGRESS");

        long closedTickets = ticketRepository.countByStatus("CLOSED");

        long totalUsers = userRepository.count();

        return new DashboardResponse(
                totalTickets,
                openTickets,
                inProgressTickets,
                closedTickets,
                totalUsers
        );
    }
}
