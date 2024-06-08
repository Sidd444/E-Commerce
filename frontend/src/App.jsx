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
    <div>
      <Navbar />
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
  );
}

export default App;
