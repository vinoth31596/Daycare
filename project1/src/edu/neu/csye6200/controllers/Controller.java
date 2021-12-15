package edu.neu.csye6200.controllers;

public interface Controller {
	public default void initView() {
	}

	public default void initController() {
	}
}
