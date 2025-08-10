import React from 'react';
import styles from '../CohortDetails.module.css';


function CohortDetails({ name, status, startDate, coach, trainer }) {
  // green for ongoing, blue otherwise (lab requirement)
  const headerStyle = { color: status === 'ongoing' ? 'green' : 'blue' };

  return (
    <div className={styles.box}>
      <h3 style={headerStyle}>{name}</h3>
      <dl>
        <dt>Started On</dt>
        <dd>{startDate}</dd>
        <dt>Current Status</dt>
        <dd>{status.charAt(0).toUpperCase() + status.slice(1)}</dd>
        <dt>Coach</dt>
        <dd>{coach}</dd>
        <dt>Trainer</dt>
        <dd>{trainer}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
