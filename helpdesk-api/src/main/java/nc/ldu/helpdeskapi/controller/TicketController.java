package nc.ldu.helpdeskapi.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import nc.ldu.helpdeskapi.model.Ticket;
import nc.ldu.helpdeskapi.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;
    
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> tous() {
        return ticketService.tous();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> unTicket(@PathVariable Long id) {
        return ticketService.chercherParId(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ticket> creer(@RequestBody Ticket ticket) {
    Ticket ticketCree = ticketService.ajouter(ticket);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ticketCree);
    }
}