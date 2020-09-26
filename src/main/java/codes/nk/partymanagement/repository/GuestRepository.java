package codes.nk.partymanagement.repository;

import codes.nk.partymanagement.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {
}
