package com.majella.ordermanagerbff.entrypoint.api.controller.payload.response;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MenuModelResponse {

    private Set<ToolbarItem> toolbarItems;
    private List<Card> cards;

}
