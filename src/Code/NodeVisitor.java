public abstract class NodeVisitor {		 // Implements the Node Visitor abstract class from the Visitor design pattern for inheritence

	public abstract Reminder visitProduct(Product product);

	public abstract Reminder visitTrading(Trading trading);

	public abstract void visitFacade(Facade facade);

}
