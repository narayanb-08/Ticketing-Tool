
package com.sumpositive.ticketing.ticket.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sumpositive.ticketing.ticket.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByStatus(String status);

    long countByStatus(String status);

}
