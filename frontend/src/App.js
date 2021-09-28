import './App.css';
import SearchForm from './components/SearchForm.jsx';
import ResultsTable from './components/ResultsTable.jsx';
import Tabs from './components/Tabs';
import {useState} from "react";

function App() {


  const [showTable, setShowTable] = useState(true);
  const [showTabs, setShowTabs] = useState(false);

  const [searchResults, setSearchResults] = useState([{"forenames": "Jordan", "surname":"Harrison", "dob":"1/1/1970"},
  {"forenames": "Luke", "surname":"Benson", "dob":"2/1/1970"}]);
  const [searchId, setSearchId] = useState("");
  

  return (
    <div>
      <h2>Redshift application</h2>
      <SearchForm setShowTable={setShowTable} setShowTabs={setShowTabs} setSearchResults={setSearchResults} searchResults={searchResults}/>
      <ResultsTable showTable={showTable} searchResults={searchResults} setSearchId={setSearchId}/>
      <Tabs showTabs={showTabs} searchId={searchId}/>
    </div>
  );
}

export default App;
