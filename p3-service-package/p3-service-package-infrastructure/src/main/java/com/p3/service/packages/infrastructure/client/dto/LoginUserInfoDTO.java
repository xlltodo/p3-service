package com.p3.service.packages.infrastructure.client.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class LoginUserInfoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7439540826413942903L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 权限列表
     */
    private Set<String> permissions;

    /**
     * 用户信息
     */
    private SysUser user;

    /**
     * 仓库编号
     */
    private Integer warehouseNo;

    /**
     * 允许查看的仓库范围
     */
    private List<Integer> warehouseNos;

    @Data
    public static class SysUser implements Serializable {

        @Serial
        private static final long serialVersionUID = 3749791579296858539L;

        /**
         * 用户ID
         */
        private Long userId;

        /**
         * 部门ID
         */
        private Long deptId;

        /**
         * 用户账号
         */
        private String userName;

        /**
         * 用户昵称
         */
        private String nickName;

        /**
         * 用户邮箱
         */
        private String email;

        /**
         * 手机号码
         */
        private String phonenumber;

        /**
         * 用户性别
         */
        private String sex;

        /**
         * 用户头像
         */
        private String avatar;

        /**
         * 密码
         */
        private String password;

        /**
         * 帐号状态（0正常 1停用）
         */
        private String status;

        /**
         * 删除标志（0代表存在 2代表删除）
         */
        private String delFlag;

        /**
         * 最后登录IP
         */
        private String loginIp;

        /**
         * 最后登录时间
         */
        private Date loginDate;

        /**
         * 部门对象
         */
        private SysDept dept;

        /**
         * 角色对象
         */
        private List<SysRole> roles;

        /**
         * 角色组
         */
        private Long[] roleIds;

        /**
         * 岗位组
         */
        private Long[] postIds;

        /**
         * 角色ID
         */
        private Long roleId;

        /**
         * 是否能使用pc，默认1可以，0不行
         */
        private Boolean pcStatus;

        /**
         * 是否能使用app，默认1可以，0不行
         */
        private Boolean appStatus;

        /**
         * 货物仓库
         */
        private Integer orderWarehouse;

        /**
         * E3员工编号
         */
        private String e3StaffNo;

        /** 创建者 */
        private String createBy;

        /** 创建时间 */
        private Date createTime;

        /** 更新者 */
        private String updateBy;

        /** 更新时间 */
        private Date updateTime;

        /** 备注 */
        private String remark;

    }

    @Data
    public static class SysDept implements Serializable{

        @Serial
        private static final long serialVersionUID = -597255476313744836L;

        /**
         * 部门ID
         */
        private Long deptId;

        /**
         * 父部门ID
         */
        private Long parentId;

        /**
         * 祖级列表
         */
        private String ancestors;

        /**
         * 部门名称
         */
        private String deptName;

        /**
         * 显示顺序
         */
        private Integer orderNum;

        /**
         * 负责人
         */
        private String leader;

        /**
         * 联系电话
         */
        private String phone;

        /**
         * 邮箱
         */
        private String email;

        /**
         * 部门状态:0正常,1停用
         */
        private String status;

        /**
         * 删除标志（0代表存在 2代表删除）
         */
        private String delFlag;

        /**
         * 父部门名称
         */
        private String parentName;

        /**
         * 部门英文名称
         */
        private String deptEnglishName;

        /**
         * 部门泰文名称
         */
        private String deptThaiName;

        /**
         * 部门类型
         */
        private Integer deptType;

        /**
         * 所属财务中心
         */
        private Long financeDeptId;

        /**
         * 所属财务中心
         */
        private String financeDeptName;

        /**
         * 仓库前缀
         */
        private String warehousePrefix;

        /**
         * 货物仓库
         */
        private Integer orderWarehouse;

        /**
         * 所属客户
         */
        private String deptUserId;

        /**
         * 地址
         */
        private String deptAddress;

        /**
         * 部门所属国家
         */
        private String deptCountry;

        /**
         * 子部门
         */
        private List<SysDept> children;
    }

    @Data
    public static class SysRole implements Serializable {

        @Serial
        private static final long serialVersionUID = -6241722105177070235L;

        /** 角色ID */
        private Long roleId;

        /** 角色名称 */
        private String roleName;

        /** 角色权限 */
        private String roleKey;

        /** 角色排序 */
        private Integer roleSort;

        /** 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限） */
        private String dataScope;

        /** 菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示） */
        private boolean menuCheckStrictly;

        /** 部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ） */
        private boolean deptCheckStrictly;

        /** 角色状态（0正常 1停用） */
        private String status;

        /** 删除标志（0代表存在 2代表删除） */
        private String delFlag;

        /** 用户是否存在此角色标识 默认不存在 */
        private boolean flag = false;

        /** 菜单组 */
        private Long[] menuIds;

        /** 部门组（数据权限） */
        private Long[] deptIds;

        /** 角色菜单权限 */
        private Set<String> permissions;
    }
}
