import Associate from "./Associate";

const AssociateTable = ({associates}) => {
    return (
        <table className="topHeads">
            <thead>
                <tr>
                    <td>Forename(s)</td>
                    <td>Surname</td>
                    <td>Date of birth</td>
                </tr>
            </thead>
            <tbody>
                {associates.map(({personID, personForenames, personSurname, personDOB})=> <Associate key={personID} forenames={personForenames} surname={personSurname} dob={personDOB}/>)}
            </tbody>
        </table>
    )
}

export default AssociateTable;