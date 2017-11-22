package model;

public enum Symbols {
	SYMBOL_1("000",1),
	SYMBOL_2("001",1),
	SYMBOL_3("010",2),
	SYMBOL_4("011",2),
	SYMBOL_5("100",2),
	SYMBOL_6("101",5),
	SYMBOL_7("110",5),
	SYMBOL_8("111",5),
	SYMBOL_9("FOO",10),
	SYMBOL_10("BAR",100);
	
	private final String symbolString;
	private final int winTimesBet;
	
	Symbols(String symbolString, int winTimesBet) {
      this.symbolString = symbolString;
      this.winTimesBet = winTimesBet;
	}
	
	public String toString() {
		return symbolString;
	}

	public int getWinTimesBet() {
		return winTimesBet;
	}
}
