import Phone from "./elements/Phone";
import { useEffect, useState } from "react";
import axios from "axios";

const Telephone = (searchId) => {

    const [phones, setPhones] = useState([]);

    useEffect(() => {
        axios.get(`http://54.247.130.198:8081/getPhoneByPersonId/${searchId.searchId}`) 
        .then(({data}) => {        
            setPhones(data);
        })
        .catch (err => console.log(err));
    }, [searchId]);

    return (
        <>
            <div className="dataDisplay"><strong>Telephones associated with individual:</strong>
            {phones.map(({mobilePhoneId, mobilePhoneNumber, mobilePhoneOperator}) => <Phone key={mobilePhoneId} number={mobilePhoneNumber} operator={mobilePhoneOperator}/>)}
            </div>
        </>
    )
}

export default Telephone;