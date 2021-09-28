import { useEffect, useState } from "react";
import axios from "axios";
import BusinessAddress from "./elements/BusinessAddress";
import Address from "./elements/Address";

const Addresses = (searchId) => {

            const [businessAddresses, setBusinessAddresses] = useState([]);
            const [addresses, setAddresses] = useState([]);
            
            useEffect(() => {
                axios.get(`http://54.247.130.198:8081/getBusinessAddressPersonId/${searchId.searchId}`) 
                .then(({data}) => {        
                    setBusinessAddresses(data);
                })
                .catch (err => console.log(err));

                axios.get(`http://54.247.130.198:8081/getAddressPersonId/${searchId.searchId}`) 
                .then(({data}) => {        
                    setAddresses(data);
                })
                .catch (err => console.log(err));

            }, [searchId]);

            const showHide = ({target}, str) => {
                const subData = target.nextSibling;
                str= target.id;
                if (subData.className==="hide") {
                    subData.className = "show";
                    target.innerText = `Hide ${str} \u25B2`
                } else {
                    subData.className = "hide";
                    target.innerText = `Show ${str} \u25BC`
                }
            }

    return (
        <>
            <div className="dataDisplay"><strong>Addresses associated with individual:</strong>
                <div id="business address(es)" className="dropDownButton" onClick={(e)=>showHide(e)}>Show business address(es) &#x25BC;</div>
                <div className="hide">
                    <table className="topHeads">
                        <thead>
                            <tr>
                                <th>Business name</th>
                                <th>Business type</th>
                                <th>House</th>
                                <th>Street</th>
                                <th>Town</th>
                                <th>Postcode</th>
                            </tr>
                        </thead>
                        <tbody>
                            {businessAddresses.map(({businessAddressId, businessName, businessAddressStreetName, businessAddressTypeOfBusiness, businessAddressPostcode, businessAddressTown, businessAddressHouseNumber}) => <BusinessAddress key={businessAddressId} name={businessName} type={businessAddressTypeOfBusiness} house={businessAddressHouseNumber} street={businessAddressStreetName} town={businessAddressTown} postcode={businessAddressPostcode}/>)}
    
                        </tbody>
                    </table>
                </div>
                <div id="home address(es)" className="dropDownButton" onClick={(e)=>showHide(e)}>Show home address(es) &#x25BC;</div>
                <div className="hide">
                    <table className="topHeads">
                        <thead>
                            <tr>
                                <th>House number</th>
                                <th>Street</th>
                                <th>Town</th>
                                <th>Postcode</th>
                            </tr>
                        </thead>
                        <tbody>
                            {addresses.map(({addressId, streetName, postcode, town, houseNumber}) => <Address key={addressId} house={houseNumber} street={streetName} town={town} postcode={postcode}/>)}
    
                        </tbody>
                    </table>
                </div>
            </div>
        </>
    )
}

export default Addresses;