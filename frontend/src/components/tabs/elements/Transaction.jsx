const Transaction = ({timestamp, amount, atmEPOS, type}) => {
    return (
        <>

            <table className="subDataTable">
                <tbody>
                    <tr>
                        <td>Time</td>
                        <td>{timestamp}</td>
                    </tr>
                    <tr>
                        <td>ATM/EPOS</td>
                        <td>{atmEPOS}</td>
                    </tr>
                    <tr>
                        <td>Type</td>
                        <td>{type}</td>
                    </tr>
                    <tr>
                        <td>Amount</td>
                        <td>£{amount}</td>
                    </tr>
                </tbody>
            </table>

        </>

    )
}

export default Transaction;