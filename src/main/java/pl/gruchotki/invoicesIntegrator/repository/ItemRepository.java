package pl.gruchotki.invoicesIntegrator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gruchotki.invoicesIntegrator.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

//    List<ItemEntity> getItemsByInvoiceId(Long invoiceId);
}
