package com.costa.Edicola.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "biglietti")
@Getter @Setter 
@AllArgsConstructor
public class Giornaliero extends Biglietto {
	
}
