package com.mm.surrealdb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SequenceEntity {
    String id;
    Long seq_value;
}
