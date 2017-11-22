package model;

public enum Symbols {
	SYMBOL_1("000"),
	SYMBOL_2("001"),
	SYMBOL_3("010"),
	SYMBOL_4("011"),
	SYMBOL_5("100"),
	SYMBOL_6("101"),
	SYMBOL_7("110"),
	SYMBOL_8("111"),
	SYMBOL_9("FOO"),
	SYMBOL_10("BAR");
	
	private final String symbolString;
	
	Symbols(String symbolString) {
      this.symbolString = symbolString;
	}
	
	public String toString() {
		return symbolString;
	}

	public int getWinTimesBet() {
		// TODO Auto-generated method stub
		return 0;
	}
}
