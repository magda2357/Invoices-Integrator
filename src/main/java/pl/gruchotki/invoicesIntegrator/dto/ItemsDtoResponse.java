package pl.gruchotki.invoicesIntegrator.dto;

import lombok.Getter;
import pl.gruchotki.invoicesIntegrator.entity.ItemEntity;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class ItemsDtoResponse {
    private final List<ItemDtoResponse> items;

    public ItemsDtoResponse(List<ItemEntity> items) {
        this.items = items.stream()
                .map(ItemDtoResponse::new)
                .collect(toList());

    }
}
