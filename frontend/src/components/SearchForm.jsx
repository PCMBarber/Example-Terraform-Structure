import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

const SearchForm = ({setShowTable, setShowTabs, setSearchResults, searchResults}) => {
    
    const submitForm = (e) => {
        e.preventDefault();
        setShowTable(true);
        setShowTabs(true);
        const forename = e.target.forename.value;
        const surname = e.target.surname.value;
        const dob = e.target.dob.value;
        
        axios.get(`http://54.247.130.198:8081/getFromSearch/${forename}/${surname}/${dob}`) 
            .then(({data}) => {        
                setSearchResults(data);
            })
            .catch (err => console.log(err));
    };
    
    return (
        
            <form className="searchForm" onSubmit={(e)=>submitForm(e)}>
                <div className="row">
                    <div className="column1">
                        <label for="forename">Forenames: </label>
                    </div>
                    <div className="column2">
                        <input type="text" id="forename" name="forename" className="formInput"/>
                    </div>
                </div>
                <br/>
                <div className="row">
                    <div className="column1">
                        <label for="surname">Surname: </label>
                    </div>
                    <div className="column2">
                        <input type="text" id="surname" name="surname" className="formInput"/>
                    </div>
                </div>
                <br/>
                <div className="row">
                    <div className="column1">
                        <label for="dob">Date of birth: </label>
                    </div>
                    <div className="column2">
                        <input type="text" id="dob" name="dob" className="formInput"/>
                    </div>
                </div>
                <br/>
                <div className="row">
                    <input type="submit" id="submit" name="submit" className="formInput" />
                </div>
                <br/>
            </form>
        
 


    )
}


export default SearchForm;