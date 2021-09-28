import {Link} from 'react-router-dom';

const Nav = () => {
    
    const changeTab = (e) => {
        document.querySelectorAll("nav > a").forEach(e => e.className = "inactive");
        e.target.className = "active";
    };
    
    return (
        <nav>
            <Link to="/" onClick={(e)=>changeTab(e)}>
            Biographical
            </Link>            
            <Link to="/addresses" onClick={(e)=>changeTab(e)}>
            Addresses
            </Link>
            <Link to="/financialTransactions" onClick={(e)=>changeTab(e)}>
            Financial Transactions
            </Link>
            <Link to="/carInfo" onClick={(e)=>changeTab(e)}>
            Vehicles
            </Link>
            <Link to="/telephone" onClick={(e)=>changeTab(e)}>
            Telephones
            </Link>
            <Link to="/associates" onClick={(e)=>changeTab(e)}>
            Associates
            </Link>
        </nav>
    )
}

export default Nav;