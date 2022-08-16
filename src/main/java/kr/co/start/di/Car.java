package kr.co.start.di;

public class Car {

	//Car는 Engine이 없으면 안된다. Car는 Engine에 의존적이다.
	// 1. private Engine engine = new Engine();
	// 2. Car car = new Car()
	//		car.engine = new Engine();
	/*
	 *3. public Car(){
	 * 	this.engine = new Engine();
	 * }*/
	/*
	 * 4.
	 * {
	 * 	this.engine = new Engine();
	 * }
	 */
	// 5. setter메소드 활용
	
	private Engine engine;
	private Wheel leftWheel;
	private Wheel rightWheel;
	
	/*@Autowired
	public Car(Engine engine, LeftWheel leftWheel, RightWheel rightWheel) {
		super();
		this.engine = engine;
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
	}*/
	
	/*@Autowired
	public Car(Engine engine, Wheel leftWheel, Wheel rightWheel) {
		// 부모 타입으로 선언해서 자식타입으로 받을수 있다.
		// 부모타입 자식타입의 빈 이름
		// 빈 이름은 따로 지정하지 않으면 클래스의 맨 앞글자를 소문자로 한것
		// 따라서 위 매개변수들은 leftWheel은 LeftWheel타입이 rightWheel은 RightWheel 타입이 들어간다.
		super();
		this.engine = engine;
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
	}*/
	
	public Car(Wheel leftWheel, Wheel rightWheel) {
		super();
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
}
