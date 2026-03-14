import { Routes, Route } from 'react-router-dom';
import LoginPage from '../pages/LoginPage';
import AdminDashboard from '../pages/AdminDashboard';
import StaffDashboard from '../pages/StaffDashboard';
import StudentDashboard from '../pages/StudentDashboard';
import AttendanceMarkPage from '../pages/AttendanceMarkPage';
import ReportsPage from '../pages/ReportsPage';
import ProtectedRoute from '../components/ProtectedRoute';

const AppRouter = () => (
  <Routes>
    <Route path="/" element={<LoginPage />} />
    <Route path="/admin" element={<ProtectedRoute role="ADMIN"><AdminDashboard /></ProtectedRoute>} />
    <Route path="/staff" element={<ProtectedRoute role="STAFF"><StaffDashboard /></ProtectedRoute>} />
    <Route path="/student" element={<ProtectedRoute role="STUDENT"><StudentDashboard /></ProtectedRoute>} />
    <Route path="/staff/attendance" element={<ProtectedRoute role="STAFF"><AttendanceMarkPage /></ProtectedRoute>} />
    <Route path="/reports" element={<ProtectedRoute><ReportsPage /></ProtectedRoute>} />
  </Routes>
);

export default AppRouter;
