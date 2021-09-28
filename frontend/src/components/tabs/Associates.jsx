import AssociateTable from "./elements/AssociateTable";
import { useEffect, useState } from "react";
import axios from "axios";

const Associates = (searchId) => {

    const [friends, setFriends] = useState([]);
    const [partners, setPartners] = useState([]);
    const [contacts, setContacts] = useState([]);
    const [colleagues, setColleagues] = useState([]);

    useEffect(() => {
        axios.get(`http://54.247.130.198:8081/getFriendsByPersonId/${searchId.searchId}`) 
        .then(({data}) => {        
            setFriends(data);
        })
        .catch (err => console.log(err));

        axios.get(`http://54.247.130.198:8081/getPartnersByPersonId/${searchId.searchId}`) 
        .then(({data}) => {        
            setPartners(data);
        })
        .catch (err => console.log(err));

        axios.get(`http://54.247.130.198:8081/getPhoneContactsByPersonId/${searchId.searchId}`) 
        .then(({data}) => {        
            setContacts(data);
        })
        .catch (err => console.log(err));

        axios.get(`http://54.247.130.198:8081/getColleaguesByPersonId/${searchId.searchId}`) 
        .then(({data}) => {        
            setColleagues(data);
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
        <div className="dataDisplay"><strong>Known associates of individual:</strong>
            <div id="partner(s)" className="dropDownButton" onClick={(e)=>showHide(e)}>Show partner(s) &#x25BC;</div>
            <div className="hide">
                        <AssociateTable associates={partners}/>
            </div>
            <div id="friend(s)" className="dropDownButton" onClick={(e)=>showHide(e)}>Show friend(s) &#x25BC;</div>
            <div className="hide">
                        <AssociateTable associates={friends}/>
            </div>
            <div id="phone contact(s)" className="dropDownButton" onClick={(e)=>showHide(e)}>Show phone contact(s) &#x25BC;</div>
            <div className="hide">
                        <AssociateTable associates={contacts}/>
            </div>
            <div id="colleague(s)" className="dropDownButton" onClick={(e)=>showHide(e)}>Show colleague(s) &#x25BC;</div>
            <div className="hide">
                        <AssociateTable associates={colleagues}/>
            </div>
        </div>
    )
}
export default Associates;