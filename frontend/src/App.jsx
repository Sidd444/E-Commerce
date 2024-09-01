import { Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './pages/Home';
import AddSeller from './pages/AddSeller';
import AddProduct from './pages/AddProduct';
import AddCustomer from './pages/AddCustomer';
import PlaceOrder from './pages/PlaceOrder';
import Cart from './pages/Cart';
import AddCard from './pages/AddCard';

function App() {
  return (
    <div className="min-h-screen bg-green-100">
      <Navbar className="fixed top-0 left-0 w-full bg-blue-600 z-50" />
      <div className="pt-10">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/add-seller" element={<AddSeller />} />
          <Route path="/add-product" element={<AddProduct />} />
          <Route path="/add-customer" element={<AddCustomer />} />
          <Route path="/place-order" element={<PlaceOrder />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/add-card" element={<AddCard />} />
        </Routes>
      </div>
    </div>

  );
}

export default App;
