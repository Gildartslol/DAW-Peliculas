package dao;

import java.util.ArrayList;


public class Qry {

	private ArrayList<String> qryAnterior;
	private ArrayList<String> qryFinal;
	private int i = 1;

	public Qry(String qry) {
		qryAnterior = new ArrayList<>();
		qryFinal = new ArrayList<>();

		String[] qryArray = qry.split(" ");
		for (int i = 0; i < qryArray.length; i++) {
			qryAnterior.add(qryArray[i]);
		}

	}

	public void setParam(double param){
		setParam(String.valueOf(param));
	}
	public void setParam(int param){
		setParam(String.valueOf(param));
	}
	public void setParam(String param) {
		String buscado = "&" + i;
		qryFinal.clear();
		for (String string : qryAnterior) {

			String replace = string.replaceAll(buscado,  param );
			qryFinal.add(replace);
		}
		copiarArray(qryFinal);
		i++;
	}
	
	public void setStringParam(double param){
		setStringParam(String.valueOf(param));
	}
	public void setStringParam(int param){
		setStringParam(String.valueOf(param));
	}
	public void setStringParam(String param) {
		String buscado = "&" + i;
		qryFinal.clear();
		for (String string : qryAnterior) {
			
			
			String replace = string.replaceAll(buscado, "'"+ param +"'");
			qryFinal.add(replace);
		}
		copiarArray(qryFinal);
		i++;
	}
	
	
	private void copiarArray(ArrayList<String> arr){
		qryAnterior.clear();
		for (String str : arr) {
			qryAnterior.add(str);
		}
	}
	

	@Override
	public String toString() {
		ArrayList<String> recorrido;
		if(i==1){
			recorrido = qryAnterior;
		}else{
			recorrido = qryFinal;
		}
		StringBuilder sb = new StringBuilder();
		for (String string : recorrido) {
			sb.append(string + " ");
		}
		return sb.toString();
	}

}
