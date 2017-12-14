package main;

public interface FuelStation {
	public float PETROL_PRICE = 80.0f;
	public int refillTank(int litres)throws RefillException;
	public float dispense(int litres)throws StockException;
	public float amountCollected();
	public int getStockLitres();
	public int getSoldLitres();
	
}
