import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav className="bg-blue-600 p-4 ml-2 rounded-2xl">
      <ul className="flex space-x-4 gap-24">
        <li><Link className='text-white font-bold text-xl' to="/">Home</Link></li>
        <li><Link className='text-white font-bold text-xl' to="/add-seller">Add Seller</Link></li>
        <li><Link className='text-white font-bold text-xl' to="/add-product">Add Product</Link></li>
        <li><Link className='text-white font-bold text-xl' to="/add-customer">Add Customer</Link></li>
        <li><Link className='text-white font-bold text-xl' to="/add-card">Add Card</Link></li>
        <li><Link className='text-white font-bold text-xl' to="/place-order">Place Order</Link></li>
        <li><Link className='text-white font-bold text-xl' to="/cart">Cart</Link></li>
      </ul>
    </nav>
  );
};

export default Navbar;
