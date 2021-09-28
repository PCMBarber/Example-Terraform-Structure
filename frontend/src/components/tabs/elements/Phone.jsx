const Phone = ({number, operator}) => {



    return (
        <>
            <table className="dataTable">
                <tbody>
                    <tr>
                        <td>Telephone number</td>
                        <td>{number}</td>
                    </tr>
                    <tr>
                        <td>Operator</td>
                        <td>{operator}</td>
                    </tr>
                </tbody>
            </table>
        </>

    )
}

export default Phone;