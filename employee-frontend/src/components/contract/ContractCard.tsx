import type { Contract } from '../../types/types';

type Props = {
    contract: Contract;
}

const ContractCard: React.FC<Props> = ({ contract }) => {
    return (
        <div className="employee-card">
            <h3>{contract.employee}</h3>
            <p><strong>Contract ID:</strong>{contract.id}</p>
            <p><strong>Type</strong> {contract.type}</p>
            <p><strong>Start date:</strong> {contract.startDate.getDate()}</p>
            <p><strong>End date:</strong> {contract.endDate.getDate()}</p>
            <p><strong>Cost:</strong> {contract.cost}</p>
            <p><strong>Hours</strong> ${contract.hours}</p>
        </div>
    );
};

export default ContractCard;