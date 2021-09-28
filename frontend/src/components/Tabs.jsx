import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Biographical from './tabs/Biographical';
import FinancialTransactions from './tabs/FinancialTransactions';
import Nav from './Nav';
import CarInfo from './tabs/CarInfo';
import Telephone from './tabs/Telephone';
import Associates from './tabs/Associates';
import Addresses from './tabs/Addresses';

const Tabs = ({showTabs, searchId}) => {

    // console.log(bankCards);

    if (showTabs === false) {
        return <></>
    } else {
        return (
            <div className="tabs">
                <Router>
                    <Nav/>
                    <Switch>
                        <Route exact path="/">
                            <Biographical searchId = {searchId}/>
                        </Route>
                        <Route path="/addresses">
                            <Addresses searchId = {searchId}/>
                        </Route>
                        <Route path="/financialTransactions">
                            <FinancialTransactions/>
                        </Route>
                        <Route path="/carInfo">
                            <CarInfo searchId = {searchId}/>
                        </Route>
                        <Route path="/telephone">
                            <Telephone searchId = {searchId}/>
                        </Route>
                        <Route path="/associates">
                            <Associates searchId = {searchId}/>
                        </Route>
                    </Switch>
                </Router>
            </div>

        );
    }
}

export default Tabs;