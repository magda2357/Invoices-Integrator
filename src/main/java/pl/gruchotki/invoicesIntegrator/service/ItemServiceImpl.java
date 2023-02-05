package pl.gruchotki.invoicesIntegrator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gruchotki.invoicesIntegrator.dto.ItemDtoResponse;
import pl.gruchotki.invoicesIntegrator.dto.ItemsDtoResponse;
import pl.gruchotki.invoicesIntegrator.repository.ItemRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public ItemsDtoResponse getInvoiceItems(Long invoiceId) {
        return null;
    }

    @Override
    public ItemDtoResponse get(Long invoiceId, Long itemId) {
        return null;
    }
}
