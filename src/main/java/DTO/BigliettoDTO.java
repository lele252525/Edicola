package DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BigliettoDTO {
	
	@Column(name = "id_biglietti")
	private Long id;
	
	@NotNull(message = "Il numero è obbligatorio")
	@Min(1)
	private int numero;
	
	@NotNull(message = "Dichiarare data di emissione")
	private String dataEmissione;
	
	private String tipo;
	private int validità;
	
	
}
