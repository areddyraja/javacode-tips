package designpatterns;

public class FactoryPattern {
	public static void main(String[] args) {

		MobileFactory factory = new LondonMobileFactory();
		SpiceMobile mobile = factory.produceMobile("SpiceHD");

		MobileFactory nyFactory = new NYMobileFactory();
		SpiceMobile mobile2 = nyFactory.produceMobile("SpiceMono");

	}

	/* Old way of producing mobiles */
	SpiceMobile produceMobile2(String model) {
		SpiceMobile mobile = null;

		if (model.equalsIgnoreCase("SpiceBolt")) {
			mobile = new SpicePlus();
		} else if (model.equalsIgnoreCase("SpiceFire")) {
			mobile = new SpiceBolt();
		}
		mobile.prepare();
		mobile.bundle();
		mobile.label();

		return mobile;
	}

}

abstract class SpiceMobile {
	public double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public abstract void prepare();

	public abstract void bundle();

	public abstract void label();
}

class SpiceFire extends SpiceMobile {
	@Override
	public void prepare() {
	}

	@Override
	public void bundle() {
	}

	@Override
	public void label() {
	}
}

class SpiceBolt extends SpiceMobile {

	@Override
	public void prepare() {
	}

	@Override
	public void bundle() {
	}

	@Override
	public void label() {
	}
}

class SpicePlus extends SpiceMobile {

	@Override
	public void prepare() {
	}

	@Override
	public void bundle() {
	}

	@Override
	public void label() {
	}
}

abstract class MobileFactory {

	public abstract SpiceMobile constructMobile(String model);

	/**
	 * Defines the process to product mobile. This implementation should'nt be
	 * be changed by clients
	 * 
	 * @param model
	 * @return SpiceMobile
	 */
	public SpiceMobile produceMobile(String model) {

		SpiceMobile mobile = constructMobile(model);
		mobile.prepare();
		mobile.bundle();
		mobile.label();

		return mobile;
	}
}

/**
 * London mobile factory is specialized and only sale Spice3D and SpiceHD.
 */
class LondonMobileFactory extends MobileFactory {

	@Override
	public SpiceMobile constructMobile(String model) {

		SpiceMobile mobile = null;

		if (model.equalsIgnoreCase("Spice3D")) {
			mobile = new SpicePlus();
			mobile.setPrice(300);
		} else if (model.equalsIgnoreCase("SpiceHD")) {
			mobile = new SpiceBolt();
			mobile.setPrice(400);
		}

		return mobile;
	}
}

/**
 * New York mobile factory is specialized and only sale Spice3D and SpiceMono.
 */

class NYMobileFactory extends MobileFactory {

	@Override
	public SpiceMobile constructMobile(String model) {

		SpiceMobile mobile = null;

		if (model.equalsIgnoreCase("SpiceFire")) {
			mobile = new SpicePlus();
			mobile.setPrice(200);
		} else if (model.equalsIgnoreCase("SpiceMono")) {
			mobile = new SpiceFire();
			mobile.setPrice(280);
		}

		return mobile;
	}
}
