package it.polito.tdp.PremierLeague.model;

public class Mesi {

	String mese;
	int num;

	public Mesi(int num, String mese) {
		super();
		this.mese = mese;
		this.num = num;
	}


	@Override
	public String toString() {
		return mese ;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mese == null) ? 0 : mese.hashCode());
		result = prime * result + num;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesi other = (Mesi) obj;
		if (mese == null) {
			if (other.mese != null)
				return false;
		} else if (!mese.equals(other.mese))
			return false;
		if (num != other.num)
			return false;
		return true;
	}


	public String getMese() {
		return mese;
	}
	public void setMese(String mese) {
		this.mese = mese;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	

}
