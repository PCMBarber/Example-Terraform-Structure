import Bankcard from "./elements/Bankcard";

const FinancialTransactions = () => {
    return (
        <div className="dataDisplay"><strong>Bank cards associated with individual:</strong>
            {/* {bankCards.map(({cardNumber, sortCode, eposTransactions}) => <Bankcard cardNumber={cardNumber} sortCode={sortCode} eposTransactions={eposTransactions}/>)} */}
            <Bankcard/>
        </div>
    )
}

export default FinancialTransactions;