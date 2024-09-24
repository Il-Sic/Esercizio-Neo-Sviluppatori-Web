package converter;

import serializer.GelatoSerializer;
import entity.Gelato;

public class GelatoConverter {
	
	public static GelatoSerializer convertToSerializer (Gelato gelato) {
		GelatoSerializer serializer = new GelatoSerializer();
		serializer.setId(gelato.getId());
		serializer.setNome(gelato.getNome());
		serializer.setDescrizione(gelato.getDescrizione());
		return serializer;
		
	}

}
