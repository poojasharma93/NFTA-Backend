package com.nfta.stopsTransaction.service;

import java.util.List;

import com.nfta.stopsTransaction.model.Route;
public interface RouteService {

	public void addRoute(Route route);
	
	public List<Route> getRoutes();
}