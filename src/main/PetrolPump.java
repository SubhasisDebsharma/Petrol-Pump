package main;

public class PetrolPump implements FuelStation{
	private int capacity, stockLitres, soldLitres;
	private float amountCollected;
	
	public PetrolPump(int capacity) {
		this.capacity = capacity;
		this.soldLitres = 0;
		this.stockLitres = 0;
		this.amountCollected = 0.0f;
		
	}

	public static void main(String[] args) throws RefillException, StockException {
		FuelStation station = new PetrolPump(500);
		//station.dispense(10);	// Should throw StockException if uncommented
		station.refillTank(100);
		station.dispense(10);
		//station.refillTank(500);	// Should throw RefillException if uncommented
		station.dispense(5);
		System.out.println(station.getStockLitres());	// prints 85 
		System.out.println(station.getSoldLitres());	// prints 15
		System.out.println(station.amountCollected());	// prints 1200.00
		
		
	}

	@Override
	public int refillTank(int litres) throws RefillException {
		if(this.capacity >= this.stockLitres+litres){
			this.stockLitres += litres;
		}
		else {
			throw new RefillException("Not Enough space in Tank");
		}
		return this.stockLitres;
	}

	@Override
	public float dispense(int litres) throws StockException {
		float price;
		if(this.stockLitres-litres>=0){
			price = litres*PETROL_PRICE;
			this.stockLitres -= litres;
			this.soldLitres += litres;
			this.amountCollected += price;
			
		}
		else {
			throw new StockException("Don't have enough Petrol to dispense");
		}
		return price;
	}

	@Override
	public float amountCollected() {
		return this.amountCollected;
	}

	@Override
	public int getStockLitres() {
		return this.stockLitres;
	}

	@Override
	public int getSoldLitres() {
		return this.soldLitres;
	}

}
