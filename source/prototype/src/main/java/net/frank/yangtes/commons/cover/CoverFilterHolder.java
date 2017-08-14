package net.frank.yangtes.commons.cover;

public final class CoverFilterHolder {
	
	public static Boolean getCoverFilter(){	
		if(Helper.t.get() == null){
			Helper.t.set(Boolean.FALSE);
		}
		return Helper.t.get();
	}
	
	public static void reset(){
		Helper.t.set(Boolean.FALSE);
	}
}
