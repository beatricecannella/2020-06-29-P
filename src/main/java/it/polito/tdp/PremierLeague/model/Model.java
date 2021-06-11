package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	private Graph<Match, DefaultWeightedEdge> grafo;
	private PremierLeagueDAO dao;
	private Map <Integer, Match> idMap;
	private List<Mesi> mesi = new LinkedList<>();
	
	
	public Model() {
		dao = new PremierLeagueDAO();
		this.idMap = new HashMap<>();
		dao.listAllMatches(idMap);
		
	}
	
	public void creaGrafo( Mesi meseString, int min) {
		int meseNum= this.getMeseNum(meseString);
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(grafo, dao.getVertex(idMap, meseNum));
		
		for(Adiacenza a : dao.getAdiacenze(idMap, meseNum, min)) {
			if(this.grafo.vertexSet().contains(a.getM1())&& this.grafo.vertexSet().contains(a.getM2())) {
				if(!grafo.containsEdge(a.getM1(), a.getM2()) || !grafo.containsEdge(a.getM2(), a.getM1())) {
			Graphs.addEdge(this.grafo, a.getM1(), a.getM2(), a.getPeso());
		}}
		}
	}
	
	public int archi() {
		return this.grafo.edgeSet().size();
	}
	public int vertici() {
		return this.grafo.vertexSet().size();
	}
	
	public Graph<Match, DefaultWeightedEdge> getGrafo(){
		return this.grafo;
	}

	
	public List<Mesi> getMesi(){
		
		 Mesi m1 = new Mesi(1, "Gennaio");
		 Mesi m2 = new Mesi(2, "Febbraio");
		 Mesi m3 = new Mesi(3, "Marzo");
		 Mesi m4 = new Mesi(4, "Aprile");
		 Mesi m5 = new Mesi(5, "Maggio");
		 Mesi m6 = new Mesi(6, "Giugno");
		 Mesi m7 = new Mesi(7, "Luglio");
		 Mesi m8 = new Mesi(8, "Agosto");
		 Mesi m9 = new Mesi(9, "Settembre");
		 Mesi m10 = new Mesi(10, "Ottobre");
		 Mesi m11= new Mesi(11, "Novembre");
		 Mesi m12 = new Mesi(12, "Dicembre");
		 mesi.add(m1);
		 mesi.add(m2);
		 mesi.add(m3);
		 mesi.add(m4);
		 mesi.add(m5);
		 mesi.add(m6);
		 mesi.add(m7);
		 mesi.add(m8);
		 mesi.add(m9);
		 mesi.add(m10);
		 mesi.add(m11);
		 mesi.add(m12);
		 
	
		 return mesi;
	}
	
	public int getMeseNum(Mesi meseString) {
		int meseNum =0;
		for(Mesi m: this.getMesi()) {
			if(m.equals(meseString)) {
				meseNum = m.getNum();
			}
		}
		return meseNum;
	}
	
}
