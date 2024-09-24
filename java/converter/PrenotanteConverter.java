package converter;

import entity.Prenotante;
import serializer.PrenotanteSerializer;

public class PrenotanteConverter {
	
	public static PrenotanteSerializer convertToSerializer (Prenotante prenotante) {
		PrenotanteSerializer serializer = new PrenotanteSerializer();
		serializer.setId(prenotante.getId());
		serializer.setNome(prenotante.getNome());
		return serializer;
		
	}

}
