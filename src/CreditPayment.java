public class CreditPayment extends Payment {

	@Override
	public void payDriver(Member driver, Member passenger, float amt, boolean payType) {
		// TODO Auto-generated method stub
		
		passenger.payDriver(amt, payType);
		driver.addPoints(amt);
	}

	
}
