package programsko;

import static org.junit.Assert.*;

import junit.framework.Assert;

public class Test {
	private int greska = 1;
	
	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void testUcitanjaPodataka() {
		UcitajPodatke uc = new UcitajPodatke("C:/Users/Boris/Desktop/JDT/novi.arff","C:/Users/Boris/Desktop/JDT/novi.arff");
		if(uc != null) {
			greska = 0;
		}
		Assert.assertEquals(0, greska);
	}

	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void testUcitanjaPodatakaKriviFormat() {
		UcitajPodatke uc = new UcitajPodatke("C:/Users/Boris/Desktop/JDT/novi1.csv","C:/Users/Boris/Desktop/JDT/novi.arff");
		if(uc != null) {
			greska = 0;
		}
		Assert.assertEquals(1, greska);
	}
	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void testTresholdRada() {
		UcitajPodatke ucitavanje = new UcitajPodatke("C:/Users/Boris/Desktop/JDT/novi.arff","C:/Users/Boris/Desktop/JDT/novi.arff");
		try {
			ThresholdRad.manipuliraj(ucitavanje);
			greska = 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(0, greska);
	}
	
	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void testIzvjestaja() {
		Izvjestaj.Pisi("TESTIRANJE IZVJESTAJA ");
		greska = 0;
		Assert.assertEquals(0, greska);
	}
	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void testGrapha() {
		Double[] poljetocnosti =   {1.,2.,3.,4.,5.,6.,7.,8.};
		Double[] xos =  {1.,2.,3.,4.,5.,6.,7.,8.};
		Double[] geomtocnosto =   {1.,2.,3.,4.,5.,6.,7.,8.};
		int brojactoc = 8, brojactresh = 8;
		Guii.Graph(poljetocnosti,geomtocnosto,brojactresh,xos);
		greska = 0;
		Assert.assertEquals(0, greska);
		
	}
	
	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void testPretvorbe() {
		
		try {
			UcitajPodatke.pretvorba("C:/Users/Boris/Desktop/JDT/novi1.csv","C:/Users/Boris/Desktop/JDT","test");
			greska = 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		Assert.assertEquals(0, greska);
		
	}
	
	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void testPretvorbeKriviFormat() {
		
		try {
			UcitajPodatke.pretvorba("C:/Users/Boris/Desktop/JDT/novi.arff","C:/Users/Boris/Desktop/JDT","test");
			greska = 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		Assert.assertEquals(0, greska);
		
	}
	
	
	
	
}
