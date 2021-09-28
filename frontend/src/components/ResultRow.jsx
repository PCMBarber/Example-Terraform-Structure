const ResultRow = ({id, forenames, surname, dob, setSearchId}) => {
    
    const selectRow = ({target}) => {
        // set clicked row to active and restyle
        document.querySelectorAll("#resultsTable > tbody > tr").forEach(row => {
            row.className = "";
        });
        target.parentElement.className = "selected";
        setSearchId(target.parentElement.id);
        console.log(target.parentElement.id);
    }

    if(console.log===undefined) {
        console.log(dob);
    }
    

    return(
        <tr id={id} onClick={(e)=>selectRow(e)}>
            <td>{forenames}</td>
            <td>{surname}</td>
            <td>{dob}</td>
        </tr>
    );
}

export default ResultRow;