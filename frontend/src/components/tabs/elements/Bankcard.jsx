import Transaction from "./Transaction";

// const Bankcard = ({cardNumber, sortCode, eposTransactions}) => {
    const Bankcard = () => {

    const showHideTable = ({target}) => {
        const subData = target.parentElement.children[2];
        if (subData.className==="hide") {
            subData.className = "show";
            target.innerText = "Hide associated transactions \u25B2"
        } else {
            subData.className = "hide";
            target.innerText = "Show associated transactions \u25BC"
        }
    }
    

    return (
        <>
        <div>
            <table className="dataTable">
                <tbody>
                    <tr>    
                        <td>Bank card number</td>
                        <td>test</td>
                    </tr>
                    <tr>
                        <td>Sort code</td>
                        <td>test</td>
                    </tr>
                </tbody>
            </table>
            <div className="dropDownButton" onClick={(e)=>showHideTable(e)}>Show associated transactions &#x25BC;</div>
            <div className="hide">
                {/* {eposTransactions.map(({timestamp, amount}) => <Transaction timestamp={timestamp} amount={amount} atmEPOS="EPOS" type="-"/>)} */}
                <Transaction/>
            </div>
        </div>
        </>

    )
}

export default Bankcard;