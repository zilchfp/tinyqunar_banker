<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-tickets"></i> 订单管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <!--<el-button type="primary" icon="delete" class="handle-del mr10" @click="delAll">批量删除</el-button>-->
                <!--<el-select v-model="select_cate" placeholder="筛选省份" class="handle-select mr10">-->
                    <!--<el-option key="1" label="广东省" value="广东省"></el-option>-->
                    <!--<el-option key="2" label="湖南省" value="湖南省"></el-option>-->
                <!--</el-select>-->
                <!--<el-input v-model="select_word" placeholder="筛选关键词" class="handle-input mr10"></el-input>-->
                <!--<el-button type="primary" icon="search" @click="search">搜索</el-button>-->
                <el-button type="primary" icon="addTicket" @click="addOrder">添加订单</el-button>
            </div>
            <el-table :data="data" border style="width: 100%" ref="multipleTable" @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="55"></el-table-column>
                <el-table-column prop="id" label="订单ID" width="120">
                </el-table-column>
                <el-table-column prop="deal_date" label="交易日期" width="120">
                </el-table-column>
                <el-table-column prop="deal_time" label="交易时间" width="120">
                </el-table-column>
                <el-table-column prop="money" label="交易金额" width="120">
                </el-table-column>
                <el-table-column prop="transferor_id" label="转出方ID" width="120">
                </el-table-column>
                <el-table-column prop="recipient_id" label="转入方ID" width="120">
                </el-table-column>
                <el-table-column label="操作" width="180">
                    <template slot-scope="scope">
                        <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <!--<div class="pagination">-->
                <!--<el-pagination @current-change="handleCurrentChange" layout="prev, pager, next" :total="1000">-->
                <!--</el-pagination>-->
            <!--</div>-->
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑订单" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="form" label-width="50px">
                <el-form-item label="订单ID">
                    <el-input v-model="form.id"></el-input>
                </el-form-item>
                <el-form-item label="交易日期">
                    <el-date-picker type="date" placeholder="选择日期" v-model="form.deal_date" value-format="yyyy-MM-dd" style="width: 100%;"></el-date-picker>
                </el-form-item>
                <el-form-item label="交易时间">
                    <el-input v-model="form.deal_time"></el-input>
                </el-form-item>
                <el-form-item label="交易金额">
                    <el-input v-model="form.money"></el-input>
                </el-form-item>
                <el-form-item label="转出方ID">
                    <el-input v-model="form.transferor_id"></el-input>
                </el-form-item>
                <el-form-item label="转入方ID">
                    <el-input v-model="form.recipient_id"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>


        <!-- 添加订单弹出框 -->
        <el-dialog title="添加新订单" :visible.sync="addEditVisible" width="30%">
            <el-form ref="form" :model="form" label-width="50px">
                <!--<el-form-item label="订单ID">-->
                    <!--<el-input v-model="form.id"></el-input>-->
                <!--</el-form-item>-->
                <el-form-item label="交易日期">
                    <el-date-picker type="date" placeholder="选择日期" v-model="form.deal_date" value-format="yyyy-MM-dd" style="width: 100%;"></el-date-picker>
                </el-form-item>
                <el-form-item label="交易时间">
                    <el-input v-model="form.deal_time"></el-input>
                </el-form-item>
                <el-form-item label="交易金额">
                    <el-input v-model="form.money"></el-input>
                </el-form-item>
                <el-form-item label="转出方ID">
                    <el-input v-model="form.transferor_id"></el-input>
                </el-form-item>
                <el-form-item label="转入方ID">
                    <el-input v-model="form.recipient_id"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addEditVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveAddEdit">确 定</el-button>
            </span>
        </el-dialog>


        <!-- 删除提示框 -->
        <el-dialog title="提示" :visible.sync="delVisible" width="300px" center>
            <div class="del-dialog-cnt">删除不可恢复，是否确定删除？</div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="delVisible = false">取 消</el-button>
                <el-button type="primary" @click="deleteRow">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>




<script>
    export default {
        name: 'basetable',
        data () {
            return {
                baseurl:'http://localhost:10003',
                url: './static/vuetable.json',
                tableData: [],
                cur_page: 1,
                multipleSelection: [],
                select_cate: '',
                select_word: '',
                del_list: [],
                is_search: false,
                editVisible: false,
                addEditVisible: false,
                delVisible: false,
                form: {
                    id: '',
                    deal_date: '',
                    deal_time: '',
                    money:'',
                    transferor_id:'',
                    recipient_id:'',
                },
                idx: -1
            }
        },
        created() {
            this.getData();
        },
        computed: {
            data() {
                return this.tableData.filter((d) => {

                    return d;  //不过滤
                    let is_del = false;
                    for (let i = 0; i < this.del_list.length; i++) {
                        if (d.name === this.del_list[i].name) {
                            is_del = true;
                            break;
                        }
                    }
                    if (!is_del) {
                        if (d.address.indexOf(this.select_cate) > -1 &&
                            (d.name.indexOf(this.select_word) > -1 ||
                                d.address.indexOf(this.select_word) > -1)
                        ) {
                            return d;
                        }
                    }
                })
            }
        },
        methods: {
            // 分页导航
            handleCurrentChange(val) {
                this.cur_page = val;
                this.getData();
            },
            getData() {
                this.url = this.baseurl+ '/order/all';
                this.$axios.post(this.url, {
                    page: this.cur_page
                }).then((res) => {
                    this.tableData = res.data;
                });
            },
            search() {
                this.is_search = true;
            },
            formatter(row, column) {
                return row.address;
            },
            filterTag(value, row) {
                return row.tag === value;
            },
            handleEdit(index, row) {
                this.idx = index;
                const item = this.tableData[index];
                this.form = {
                    id: item.id,
                    deal_date: item.deal_date,
                    deal_time: item.deal_time,
                    money: item.money,
                    transferor_id: item.transferor_id,
                    recipient_id: item.recipient_id,
                };
                this.editVisible = true;
            },
            handleDelete(index, row) {
                this.idx = index;
                this.delVisible = true;
            },
            delAll() {
                const length = this.multipleSelection.length;
                let str = '';
                this.del_list = this.del_list.concat(this.multipleSelection);
                for (let i = 0; i < length; i++) {
                    str += this.multipleSelection[i].name + ' ';
                }
                this.$message.error('删除了' + str);
                this.multipleSelection = [];
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            // 保存编辑
            saveEdit() {
                this.$set(this.tableData, this.idx, this.form);
                this.editVisible = false;
                this.$axios({
                    method: 'post',
                    url: this.baseurl + '/ticket/add',
                    headers: { 'Content-type': 'application/json;charset=UTF-8' },
                    data: JSON.stringify(this.form)
                }).then((response) => {
                    this.getData();
                    this.$message.success("修改成功!");
                    this.addEditVisible = false;
                })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            // 确定删除
            deleteRow(){
                //
                this.delVisible = false;
                this.$axios({
                    method: 'post',
                    url: this.baseurl + '/order/delete',
                    headers: { 'Content-type': 'application/json' },
                    params: {
                        id:this.tableData[this.idx].id,
                    }
                }).then(() => {
                    this.getData();
                    this.$message.success("删除成功!");
                })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            //添加订单
            addOrder() {
                this.addEditVisible = true;
            },
            //保存添加的订单
            saveAddEdit() {
                this.$set(this.tableData, this.idx, this.form);
                this.$axios({
                    method: 'post',
                    //test for add account for balance
                    url: this.baseurl + '/deal/add',
                    //url: this.baseurl + '/order/add',
                    headers: { 'Content-type': 'application/json' },
                    data: JSON.stringify(this.form)
                }).then((response) => {
                    console.log(response);
                    if (response.data === 0) {
                        this.$message.error("转出方余额不足!");
                    } else if (respose.data === 1) {
                        this.$message.success("添加成功!");
                    }
                    this.getData();
                    this.addEditVisible = false;
                }).catch(function (error) {
                    console.log(error);
                });
            }
        }
    }

</script>



<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 300px;
        display: inline-block;
    }
    .del-dialog-cnt{
        font-size: 16px;
        text-align: center
    }
</style>
